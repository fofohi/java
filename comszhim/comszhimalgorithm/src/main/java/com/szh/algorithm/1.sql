explain select * from (select content,user_id,create_time from  jump_hash_test_1 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_2 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_3 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_4 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_5 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_6 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_7 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_8 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_9 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_10 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_11 where 1=1 and create_time > 1498666327217 union all
select content,user_id,create_time from  jump_hash_test_12 where 1=1 and create_time > 1498666327217) a order by a.create_time desc limit 0,20;




