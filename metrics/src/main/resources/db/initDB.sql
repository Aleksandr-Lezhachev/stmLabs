-- Table Attributes
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
CREATE TABLE cpu_metrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attribute_id BIGINT NOT NULL,
  FOREIGN KEY (attribute_id) REFERENCES attributes (id)

);
-- Table HDD metrics
CREATE TABLE hdd_metrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attribute_id BIGINT NOT NULL,
  FOREIGN KEY (attribute_id) REFERENCES attributes (id)
);
-- Table SSD metrics
CREATE TABLE ssd_metrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attribute_id BIGINT NOT NULL,
  FOREIGN KEY (attribute_id) REFERENCES attributes (id)
);
-- Table Task metrics
CREATE TABLE task_metrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  attribute_id BIGINT NOT NULL,
  FOREIGN KEY (attribute_id) REFERENCES attributes (id)
);
-- Table Memory metrics
CREATE TABLE memory_metrics (
  id           SERIAL NOT NULL  PRIMARY KEY,
  param        VARCHAR(1024),
  attribute_id BIGINT NOT NULL,
  FOREIGN KEY (attribute_id) REFERENCES attributes (id)
);
