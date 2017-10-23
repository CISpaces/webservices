#!/usr/bin/env python2
from __future__ import print_function

import json

from pprint import pprint

import pika

HOST = "localhost"
EXCHANGE = "cispaces_exchange"

connection = pika.BlockingConnection(pika.ConnectionParameters(host=HOST))
channel = connection.channel()

channel.exchange_declare(exchange=EXCHANGE, exchange_type="fanout")

result = channel.queue_declare(exclusive=True)
queue_name = result.method.queue

channel.queue_bind(exchange=EXCHANGE, queue=queue_name)

print(" [*] Waiting")

def callback(ch, method, properties, body):
    print(" [x] Received")
    object = json.loads(body)
    pprint(object)

channel.basic_consume(callback, queue=queue_name, no_ack=True)
channel.start_consuming()
