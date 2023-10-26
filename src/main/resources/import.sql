-- noinspection SqlResolveForFile

-- Database seeding for PARKING METERS
insert into parkingmeters (id, hour_value) values ('6f007644-5bdf-4483-bf42-fb7412f66a45', 5.5);
insert into parkingmeters (id, hour_value) values ('ab8ea442-d9bb-466d-8d47-3853091d545d', 2.75);
insert into parkingmeters (id, hour_value) values ('67459848-3af5-4c99-9276-543c331adcc1', 3.8);

-- Database seeding for PAYMENTS
insert into payments (id, license_plate, start_time, total_time, paid_value, parking_meter) values ('635a00f3-6164-48ff-a3a9-47046095eaa5', 'DBZ1E04', '2023-10-25T21:49:40.180Z', 2, 11, '6f007644-5bdf-4483-bf42-fb7412f66a45');
insert into payments (id, license_plate, start_time, total_time, paid_value, parking_meter) values ('19106451-c5ec-41ce-83b7-5f150e414367', 'FLH1G40', '2023-10-23T18:49:40.180Z', 2.5, 6.88, '6f007644-5bdf-4483-bf42-fb7412f66a45');
insert into payments (id, license_plate, start_time, total_time, paid_value, parking_meter) values ('4b4f91c8-110f-4cda-9e0e-7f5ecdb85975', 'EQG1E03', '2023-10-22T23:00:40.180Z', 1, 3.8, '6f007644-5bdf-4483-bf42-fb7412f66a45');

-- Database seeding for TICKETS
insert into tickets (id, payment, end_time) values ('6d25d927-0199-4123-ba73-877d161bf98e', '635a00f3-6164-48ff-a3a9-47046095eaa5', '2023-10-25T23:49:40.180Z');
insert into tickets (id, payment, end_time) values ('8689e521-02bc-4b1a-94d4-38a06b4a8299', '19106451-c5ec-41ce-83b7-5f150e414367', '2023-10-23T21:29:40.180Z');
insert into tickets (id, payment, end_time) values ('d23c0fbc-9207-48a1-beed-4b7e4b878570', '4b4f91c8-110f-4cda-9e0e-7f5ecdb85975', '2023-10-24T23:00:40.180Z');
