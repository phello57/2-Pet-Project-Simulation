Реализация https://zhukovsd.github.io/java-backend-learning-course/Projects/Simulation/

Карта: 
![image](https://github.com/phello57/2-Pet-Project-Simulation/assets/103268341/0439ee85-7f1d-428e-9f8b-1b8c44211550)

В каждой ячейке двумерного массива лежат Node

Точка - Entity в ноде пустая

Ноды связаны Edge со всеми Node вокруг него
![image](https://github.com/phello57/2-Pet-Project-Simulation/assets/103268341/2cf1ffde-234a-471a-bc2a-f025528c908e)


Поиск в ширину реализован с помощью Node и Edge , обернутых в PathNode
![image](https://github.com/phello57/2-Pet-Project-Simulation/assets/103268341/fc6b7b48-dbe1-405d-9ccd-c33b87060cda)

То есть мы от местоположения сущности развертываемся поиском в ширину, но дополнительно создаем обертки в виде ссылок на родителя
это дает нам то, что имея найденный узел мы будем иметь весь путь до самого начала местоположения существа




