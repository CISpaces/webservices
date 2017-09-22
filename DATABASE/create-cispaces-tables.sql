-- SQL to generate CISpaces database tables
-- J.Robinson@software.ac.uk

-- FixMe - This is insecure and needs to be randomly generated an install 
connect 'jdbc:derby://localhost:1527/gaiandb;create=true;user=gaiandb;password=passw0rd';

CREATE TABLE GAIANDB.CISPACES_USERS
(
    USER_ID char(36),
    USERNAME varchar(255),
    PASSWORD varchar(255),
    AFFILIATION varchar(10),
    LOGGED_IN int
);
INSERT INTO GAIANDB.CISPACES_USERS (USER_ID, USERNAME, PASSWORD, AFFILIATION, LOGGED_IN) VALUES ('5a90c91f-1884-4f45-bc2e-49057745293c', 'Ella', 'password', 'US', 0);
INSERT INTO GAIANDB.CISPACES_USERS (USER_ID, USERNAME, PASSWORD, AFFILIATION, LOGGED_IN) VALUES ('00de81fa-4482-404a-bbb1-5bcb1ce359ee', 'Joe', 'password', 'UK/US', 0);
INSERT INTO GAIANDB.CISPACES_USERS (USER_ID, USERNAME, PASSWORD, AFFILIATION, LOGGED_IN) VALUES ('af9ca932-8226-4c15-ba19-e4bb7e2fbaee', 'Miles', 'password', 'UK', 0);

CREATE TABLE GAIANDB.CISPACES_INFOTMP
(
    ID int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    USERNAME varchar(255),
    LASTTIME varchar(255),
    AFFILIATION varchar(255),
    LASTSET int
);

-- Tables from VC Service

CREATE TABLE GAIANDB.CISPACES_GRAPH
(
    GRAPHID varchar(255) PRIMARY KEY NOT NULL,
    USERID varchar(255),
    TIMEST timestamp,
    ISSHARED boolean,
    PARENTGRAPHID varchar(255)
);

CREATE TABLE GAIANDB.CISPACES_GRAPH_HISTORY
(
    SNAPID varchar(255) PRIMARY KEY NOT NULL,
    GRAPHID varchar(255),
    TIMEST timestamp,
    ANALYSIS CLOB,
    TITLE varchar(255),
    USERID varchar(255)
);

CREATE TABLE GAIANDB.CISPACES_NODE
(
    NODEID varchar(255) PRIMARY KEY NOT NULL,
    SOURCE varchar(255),
    UNCERT varchar(20),
    EVAL long varchar,
    TXT long varchar,
    INP varchar(20),
    DTG timestamp,
    CMT varchar(50),
    TYPE varchar(10),
    ANNOT long varchar,
    GRAPHID varchar(255),
    ISLOCKED boolean
);

CREATE TABLE CISPACES_NODE_HISTORY 
( 
nodeid varchar(255), 
source varchar (255), 
uncert varchar(20), 
eval varchar(5000),
txt varchar (5000), 
inp varchar (20), 
dtg timestamp, 
cmt varchar(50), 
type varchar(10), 
annot varchar (5000), 
graphid varchar(255),
islocked boolean, 
revisionid varchar(255),
CONSTRAINT CISPACES_NODE_HISTORY_pk PRIMARY KEY (revisionid)
);

CREATE TABLE GAIANDB.CISPACES_EDGE
(
    EDGEID varchar(255) PRIMARY KEY NOT NULL,
    TARGET varchar(255),
    SOURCE varchar(255),
    FORMEDGEID varchar(255),
    GRAPHID varchar(255),
    ISLOCKED boolean
);

CREATE TABLE CISPACES_EDGE_HISTORY 
(
    edgeid varchar(255), 
    tonodeid varchar(255),
    fromnodeid varchar(255),
    formedgeid varchar(255),
    graphid varchar(255), 
    islocked boolean, 
    revisionid varchar(255), 
    CONSTRAINT CISPACES_EDGE_pk PRIMARY KEY (revisionid)
);

-- Tables from PROVSIMP Service

CREATE TABLE GAIANDB.CISPACES_PELEM
(
    USERNAME varchar(255) NOT NULL,
    ELEMENT varchar(255) NOT NULL,
    VALUE int,
    TYPE smallint,
    CONSTRAINT CISPACES_PELEM_PK PRIMARY KEY (USERNAME, ELEMENT)
);

CREATE TABLE GAIANDB.CISPACES_PEXIST
(
    WBOXID varchar(255) NOT NULL,
    ARG varchar(1000) NOT NULL,
    CONSTRAINT CISPACES_PEXIST_PK PRIMARY KEY (WBOXID, ARG)
);

CREATE TABLE GAIANDB.CISPACES_PATHS
(
    WBOXID varchar(255),
    NDID varchar(255) NOT NULL,
    PATHID varchar(255) NOT NULL,
    TITLE varchar(255),
    HINT varchar(255),
    ARG varchar(1000),
    PREM1 varchar(550),
    PREM2 varchar(500),
    USED smallint,
    CONSTRAINT CISPACES_PATHS_PK PRIMARY KEY (NDID, PATHID)
);

CREATE TABLE GAIANDB.CISPACES_INFOPROV
(
    WBOXID varchar(255) PRIMARY KEY NOT NULL,
    PROVST CLOB,
    PLOCK smallint,
    CHAINING varchar(72)
);



