# jwd-task1-part2

1. Класс, содержащий массив, должен обьявлять поле id или name.
2. Все созданные объекты массивов сохранить в объекте-репозитории. Паттерн Repository.
3. Разработать спецификации по поиску объектов и групп объектов в репозитории. По ID(по 
имени) по элементам, например: найти все массивы, сумма(среднее значение, max, min,
количество) элементов которых больше\меньше\равно заданного.
4. Разработать методы по добавлению, удалению объектов репозитория.
5. Разработать методы сортировки наборов объектов по ID, по имени, по первому элементу, 
по числу элементов и т д. Использовать интерфейс Comparator.
6. Средние значения, sum, max и min значения должны храниться в объекте класса Warehouse. 
7. Любое изменение любого элемента массива в репозитории должно вызывать пересчет 
соответствующих значений в классе Warehouse. 
8. Для решения данной задачи использовать паттерны Observer и Singleton (для warehouse и 
repository; потокобезопасные варианты использовать запрещено)
