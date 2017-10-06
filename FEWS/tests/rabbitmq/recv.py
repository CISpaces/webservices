#!/usr/bin/env python2
from __future__ import print_function

import pika

connection = pika.BlockingConnection(pika.ConnectionParameters(host="localhost"))
channel = connection.channel()

channel.exchange_declare(exchange="factextract", exchange_type="fanout")

result = channel.queue_declare(exclusive=True)
queue_name = result.method.queue

channel.queue_bind(exchange="factextract", queue=queue_name)

print(" [*] Waiting")

def callback(ch, method, properties, body):
    print(" [x] %r" % body)

channel.basic_consume(callback, queue=queue_name, no_ack=True)
channel.start_consuming()
