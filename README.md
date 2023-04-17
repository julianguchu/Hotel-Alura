# Hotel-Alura


Programa  de Hotel Alura desarrollado  con JDK 8, Maven como gestor de dependencias , arquitectura en capas y  con Interfacegráfica (GUI) en awt y swing.


precondición: creacion de la base de datos  en motor de base de datos mysql . El script de creacion se encuentra en \src\main\java  del proyecto en este repositorio.


Login: para acceder a los modulos Crud de reservas  y huespedes será necesario ingresar los siguientes datos : Username== foxone y Password == 123456


Filtro y busquedas:  la caja de texto  que dse encuentra en la parte superior izquierda de la vista de  consultas  se  utilizará para realizar el  filtro  en las busquedas   y estará dirigido en un solo atributo  tanto  para reservas como para huespedes: 
en reservas se filtraran fechas en formato yyyy-mm-dd que apuntara a coincidencias con  el atributo "fecha de entrada" y el huespedes se filtrará apuntando al 
atruibuto "fecha de nacimiento". Si en  alguna de  los dos ("reservas o  huespedes")se ingresará  un caracter vacio  y seguido a ello  se presionara el botón "buscar",
se haría una consulta general en ambos casos, es decir, traería todas las reservas en todas las fechas de inicio y todos los huespedes para todas las fechas de 
nacimiento de los huespedes.


Eliminación de reservas:  debido al diseño de la base de datos especificada como rquerimiento desde Alura, en el momento de eliminar una reserva se presentaría
un percance de integridad  en la base de datos. Para solucionar dicho percance, en este aplicativo será necesario dirigirnos primera a la vista de huespedes,
donde se muestran en la tabla cada uno de ellos y eliminar ese registro de huesped que contenga la llave foranea de reserva que queremos eliminar. Una vez ese registro
de huesped haya sido eliminado, podremos dirigirnos sin ningun problema a  la vista de tabla de reservas y eliminar la reserva con codigo igual al que eliminamos
en  la vista  huesped.

