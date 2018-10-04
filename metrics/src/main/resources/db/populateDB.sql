-- INSERT Data in Table Attribute
INSERT INTO attributes VALUES (1, 'cpu', 78, 'UP', '2018-09-21T17:32:31.354+03:00', '2018-09-21T17:32:31.354+03:00',
                               '2018-09-21T17:32:31.354+03:00');
INSERT INTO attributes VALUES (2, 'cpu', 78.1, 'UP', '2018-09-21T17:32:32.354+03:00', '2018-09-21T17:32:32.354+03:00',
                               '2018-09-21T17:32:32.354+03:00');
INSERT INTO attributes VALUES (3, 'cpu', 78.2, 'UP', '2018-09-21T17:32:33.354+03:00', '2018-09-21T17:32:33.354+03:00',
                               '2018-09-21T17:32:33.354+03:00');
INSERT INTO attributes VALUES (4, 'hdd', 98, 'UP', '2018-09-21T17:32:31.354+03:00', '2018-09-21T17:32:31.354+03:00',
                               '2018-09-21T17:32:31.354+03:00');
INSERT INTO attributes VALUES (5, 'hdd', 98.1, 'UP', '2018-09-21T17:32:32.354+03:00', '2018-09-21T17:32:32.354+03:00',
                               '2018-09-21T17:32:32.354+03:00');
INSERT INTO attributes VALUES (6, 'hdd', 98.2, 'UP', '2018-09-21T17:32:33.354+03:00', '2018-09-21T17:32:33.354+03:00',
                               '2018-09-21T17:32:33.354+03:00');
INSERT INTO attributes VALUES (7, 'ssd', 40, 'UP', '2018-09-21T17:32:31.354+03:00', '2018-09-21T17:32:31.354+03:00',
                               '2018-09-21T17:32:31.354+03:00');
INSERT INTO attributes VALUES (8, 'ssd', 42.1, 'UP', '2018-09-21T17:32:32.354+03:00', '2018-09-21T17:32:32.354+03:00',
                               '2018-09-21T17:32:32.354+03:00');
INSERT INTO attributes VALUES (9, 'ssd', 45.2, 'UP', '2018-09-21T17:32:33.354+03:00', '2018-09-21T17:32:33.354+03:00',
                               '2018-09-21T17:32:33.354+03:00');
INSERT INTO attributes VALUES
  (10, 'taskCount', 17, 'UP', '2018-09-21T17:32:31.354+03:00', '2018-09-21T17:32:31.354+03:00',
   '2018-09-21T17:32:31.354+03:00');
INSERT INTO attributes VALUES
  (11, 'taskCount', 18, 'UP', '2018-09-21T17:32:32.354+03:00', '2018-09-21T17:32:32.354+03:00',
   '2018-09-21T17:32:32.354+03:00');
INSERT INTO attributes VALUES
  (12, 'taskCount', 19, 'UP', '2018-09-21T17:32:33.354+03:00', '2018-09-21T17:32:33.354+03:00',
   '2018-09-21T17:32:33.354+03:00');
INSERT INTO attributes VALUES (13, 'memory', 58, 'UP', '2018-09-21T17:32:31.354+03:00', '2018-09-21T17:32:31.354+03:00',
                               '2018-09-21T17:32:31.354+03:00');
INSERT INTO attributes VALUES
  (14, 'memory', 58.7, 'UP', '2018-09-21T17:32:32.354+03:00', '2018-09-21T17:32:32.354+03:00',
   '2018-09-21T17:32:32.354+03:00');
INSERT INTO attributes VALUES
  (15, 'memory', 59.3, 'UP', '2018-09-21T17:32:33.354+03:00', '2018-09-21T17:32:33.354+03:00',
   '2018-09-21T17:32:33.354+03:00');
-- INSERT Data in table CPU metrics
INSERT INTO cpu_metrics VALUES (1, 'AMD A8 4500M APU with Radeon™ HD Graphics', 1);
INSERT INTO cpu_metrics VALUES (2, 'AMD A8 4500M APU with Radeon™ HD Graphics', 2);
INSERT INTO cpu_metrics VALUES (3, 'AMD A8 4500M APU with Radeon™ HD Graphics', 3);
-- INSERT Data in table memory metrics
INSERT INTO memory_metrics VALUES (1, 'Slot1: SO-DIMM DDR3L 1600 MHz 4GiB', 13);
INSERT INTO memory_metrics VALUES (2, 'Slot1: SO-DIMM DDR3L 1600 MHz 4GiB', 14);
INSERT INTO memory_metrics VALUES (3, 'Slot1: SO-DIMM DDR3L 1600 MHz 4GiB', 15);
-- INSERT Data in Table HDD metrics
INSERT INTO hdd_metrics VALUES (1, 'TOSHIBA MQ 01ABF050', 4);
INSERT INTO hdd_metrics VALUES (2, 'TOSHIBA MQ 01ABF050', 5);
INSERT INTO hdd_metrics VALUES (3, 'TOSHIBA MQ 01ABF050', 6);
-- INSERT Data in Table SSD metrics
INSERT INTO ssd_metrics VALUES (1, 'KINGSTON MLG1267', 7);
INSERT INTO ssd_metrics VALUES (2, 'KINGSTON MLG1267', 8);
INSERT INTO ssd_metrics VALUES (3, 'KINGSTON MLG1267', 9);
-- INSERT Data in Table task metrics
INSERT INTO task_metrics VALUES (1, 10);
INSERT INTO task_metrics VALUES (2, 11);
INSERT INTO task_metrics VALUES (3, 12);

