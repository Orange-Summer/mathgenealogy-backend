# 数学家数字族谱的可视化系统-后端(mathgenealogy-backend)

## Neo4j 数据库导入数据

1. 将 mathematician.csv 和 advisor.csv（可以从 [Orange-Summer/mathgenealogy-crawler (github.com)](https://github.com/Orange-Summer/mathgenealogy-crawler) 此处的 data 文件夹中获得）放入 neo4j 目录下的 import 文件夹中。
2. 启动 neo4j 数据库。
3. 在数据库中运行下列语句：

   ```cypher
   :auto
   load csv with headers from "file:///mathematician.csv" as line
   call{
       with line
       create (:Mathematician{
           mid: toInteger(line.id),
           name: line.name,
           title: line.title,
           institution: line.institution,
           year: line.year,
           country: line.country,
           dissertation: line.dissertation,
           classification: toInteger(line.classification)})
   } in transactions
   ```

   ```cypher
   create index country_index for (m:Mathematician) on (m.country);
   create index mid_index for (m:Mathematician) on (m.mid);
   create index year_index for (m:Mathematician) on (m.year);
   create text index text_name_index for (m:Mathematician) on (m.name);
   ```

   ```cypher
   :auto
   load csv with headers from "file:///advisor.csv" as line
   call{
       with line
       match (from:Mathematician{mid:toInteger(line.pid)})
       with line, from
       match (to:Mathematician{mid:toInteger(line.aid)})
       merge (to)-[:advisorOf]->(from)
       merge (from)-[:studentOf]->(to)
   } in transactions
   ```

   ```cypher
   :auto
   match (m:Mathematician)
   call{
       with m
       match (m)-[:advisorOf*1..]->(s:Mathematician)
       with m, count(distinct s) as num
       set m.descendant = num
   } in transactions
   ```

## 项目启动

1. 修改 application.properties 中 neo4j 相关配置。
2. 运行 MathgenealogyApplication。
