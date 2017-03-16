# testTaskSpringBoot

База данных:

	* должна называться testtask
	
	* пользователя создавать не нужно, используется стандартный root

Функционал:

	* таблица создастся сама - используется Hibernate.
	
	* Работа с MySQL бекендом реализована в классе DataService
	
	* CRUD capability реализованы через интерфейс DataRepository используя готовые решения JpaRepository. Можно было также использовать интерфейс CrudRepository
	
	* REST functionality реализована через классы 
		DataController. Работу методов контроллера проверял плагином Postman 
			* получить JSON массив: http://localhost:8080/alldata
			* получить запись по id: http://localhost:8080/data/3
			* update записи: http://localhost:8080/dataupdate/3 + в body что-то вроде 
				{
				  "id": 2,
				  "rendering_engine": "Farko",
				  "browser": "Firefox 1.0",
				  "platform": "Win 98+ / OSX.2+1.7",
				  "engine_version": "1.7",
				  "css_grade": "A"
				}
			* удалить по id: http://localhost:8080/deletedata/id
			* добавить запись: http://localhost:8080/dataadd + в body JSON
			
		DataViewController (так реализовал вывод данных таблицы)
			* используется для вывода всех данных таблицы на страницу с использованием bubootstrap
			
	* Посмотреть массив JSON можно используя метод RestControllera, введя в адресную строку http://localhost:8080/alldata
	
	* Получить JSON array сгруппированным по "Rendering engine" можно введя в адресную строку http://localhost:8080/alldatasum. Правда не понимаю зачем группировать, если нечего суммировать.
