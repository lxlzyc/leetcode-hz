# 175. 组合两个表
# https://leetcode-cn.com/problems/combine-two-tables/
select p.FirstName,p.LastName,a.City,a.State from Person p left join Address a on p.PersonId = a.PersonId;