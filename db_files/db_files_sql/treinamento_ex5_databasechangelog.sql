insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('1', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:16.848625', 1, 'EXECUTED', '8:d08739b575fc0b97f1d91df42a6af163', 'createTable tableName=address', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('2', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:16.870737', 2, 'EXECUTED', '8:24181ef60dfe0dc601013b72ca175968', 'createTable tableName=person; addForeignKeyConstraint baseTableName=person, constraintName=fk_address_address_id, referencedTableName=address', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('3', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:16.890533', 3, 'EXECUTED', '8:2430609c856444400c3d5f13e0e79bd5', 'createTable tableName=legal_person; addForeignKeyConstraint baseTableName=legal_person, constraintName=fk_person_person_id, referencedTableName=person', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('4', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:16.912752', 4, 'EXECUTED', '8:f99edfcc89f6ef300665d3407f996def', 'createTable tableName=natural_person; addForeignKeyConstraint baseTableName=natural_person, constraintName=fk_person_person_id, referencedTableName=person', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('5', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:16.933785', 5, 'EXECUTED', '8:cf2fb013b5dedc196459fd606aef18fb', 'createTable tableName=account; addForeignKeyConstraint baseTableName=account, constraintName=fk_person_person_id, referencedTableName=person', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('6', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:16.955237', 6, 'EXECUTED', '8:6b2cebd790ca6c45e4f94fdf06df4313', 'createTable tableName=checking_account; addForeignKeyConstraint baseTableName=checking_account, constraintName=fk_account_account_id, referencedTableName=account', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('7', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:16.988031', 7, 'EXECUTED', '8:30632f25e68d91bd7ed9cbdd83d725a3', 'createTable tableName=savings_account; addForeignKeyConstraint baseTableName=savings_account, constraintName=fk_account_account_id, referencedTableName=account', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('8', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:17.009405', 8, 'EXECUTED', '8:4f6f0c7b7da0118499051c90f5740517', 'createTable tableName=transaction; addForeignKeyConstraint baseTableName=transaction, constraintName=fk_account_account_id, referencedTableName=account', '', null, '3.10.3', null, null, '8409296764');
insert into ex5.databasechangelog (id, author, filename, dateexecuted, orderexecuted, exectype, md5sum, description, comments, tag, liquibase, contexts, labels, deployment_id) values ('9', 'katia.silva@sgsistemas.com.br', 'classpath:/liquibase/changelog-master.xml', '2021-04-14 11:08:17.032141', 9, 'EXECUTED', '8:9bfd942f7642f3f30c602d910f9bfb0f', 'createTable tableName=transfer; addForeignKeyConstraint baseTableName=transfer, constraintName=fk_account_account_id, referencedTableName=account; addForeignKeyConstraint baseTableName=transfer, constraintName=fk_transaction_transaction_id, refere...', '', null, '3.10.3', null, null, '8409296764');