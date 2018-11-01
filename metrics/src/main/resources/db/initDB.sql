CREATE TABLE baseMetrics (
  id                 SERIAL    NOT NULL  PRIMARY KEY,
  name               VARCHAR(20),
  param        VARCHAR(1024),
  value              FLOAT     NOT NULL,
  status             VARCHAR(40),
  timeStamp          TIMESTAMP NOT NULL,
  requestTimeStamp   TIMESTAMP NOT NULL,
  operationTimeStamp TIMESTAMP NOT NULL
);
-- Table CPU metrics
CREATE TABLE cpuMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY);

-- Table HDD metrics
CREATE TABLE hddMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY
);
-- Table SSD metrics
CREATE TABLE ssdMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY
);
-- Table Task metrics
CREATE TABLE taskMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY
);
-- Table Memory metrics
CREATE TABLE memoryMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY
);
