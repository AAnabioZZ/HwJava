# Волновой Алгоритм

Суть в поиске оптимального маршрута из точки **А** в точку **Б** на двумерной карте. 

катра по сути является 2х мерным массивом , не проходимые точки можно отметить сомволами -1 
* точку А -2 = вход
* точку Б -3 = выход

1. - Из точки а по кругу проверяются клетки там где 0 ставится единица там где -1 непроходимая зона.
2. - теперь из каждой вновь отмеченной клетки проверяются клетки вокруг если там 0 ставится значение из клетко от которой идет проверка + 1 если "-1" то это не проходимо если "-2" это старт если "-3" то это финишь! 
# КАРТА ОТРИСОВННА!
Маршрут строится из точки **Б** в точку **А** 
1. из точки Б проводится сравнение клеток вокруг, выбирается с наименьшим числом.
2. записывается шал и повторяется первое действие пока не найдем точку "-2" 
## ! Алгоритм завершен, катрта построенна, путь найден!👍