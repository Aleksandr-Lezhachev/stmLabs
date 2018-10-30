CREATE TABLE attributes (
  id                 SERIAL    NOT NULL  PRIMARY KEY,
  name               VARCHAR(20),
  value              FLOAT     NOT NULL,
  status             VARCHAR(40),
  timeStamp          TIMESTAMP NOT NULL,
  requestTimeStamp   TIMESTAMP NOT NULL,
  operationTimeStamp TIMESTAMP NOT NULL
);
-- Table CPU metrics
CREATE TABLE cpuMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attributeId BIGINT NOT NULL,
  FOREIGN KEY (attributeId) REFERENCES attributes (id)

);
-- Table HDD metrics
CREATE TABLE hddMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attributeId BIGINT NOT NULL,
  FOREIGN KEY (attributeId) REFERENCES attributes (id)
);
-- Table SSD metrics
CREATE TABLE ssdMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attributeId BIGINT NOT NULL,
  FOREIGN KEY (attributeId) REFERENCES attributes (id)
);
-- Table Task metrics
CREATE TABLE taskMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  attributeId BIGINT NOT NULL,
  FOREIGN KEY (attributeId) REFERENCES attributes (id)
);
-- Table Memory metrics
CREATE TABLE memoryMetrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attributeId BIGINT NOT NULL,
  FOREIGN KEY (attributeId) REFERENCES attributes (id)
);
