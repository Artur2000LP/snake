
![Captura de pantalla 2024-10-24 205201](https://github.com/user-attachments/assets/30cf5e48-7dd3-4e57-9725-a5b93880b95c)

construir la interfaz grafica
#1

* la interfaz deve tener dos contadores de puntos y perdidas izquierdo
* a lado derecho deve tener un tener un contador tiempo para 5 segundos

agregar botana con apariciones aleatorias
#2
la botana tiene que ser un label de 25 x 25
la botana aparezca y desaparezca cada 5 segundos
la botana tiene que aparecer dentro de panel fondo


crear clase GameHelper
#8
* clase GameHelper tiene que vivir dentro de com.artur.snake
* La clase tiene que tener los siguiente metodos
  	. getRandomNumber(min, max)
	. sleep(seconds)
* Cada metodo tiene que ser static
* Utilizar los metodos de GameHelper en GameEngine
Nota: no olvidar referenciar en el commit con el numeral del issue
no olvider trabajar en una feature (start y finish)

crear snake con funcionalidades que avance en todas la direcciones
#3
* la posición de inicio de snake debe ser en la esquina superior Izquierdo
* el snake tiene que moverse siguiendo la posición del maus
* una vez que snake alcance al maus se quede quieto
* snake no debe salirse de panel fondo

agregar la funcionalidad de comer botanas
#4

*cuando el snake coma la botana:
	tiene que desaparecer la botana
	la botana tine que aparecer en otro lugar aleatorio
	que los tiempo de 5 segundos se ponga en 0
	que el snake crezca

Considerar limites de pantalla en el movimiento del snake
#10

agregar la funcionalidad de puntos
#5
* cuando el snake coma una botana que se aumente en 1 los puntos

muerte snake
#6
* snake muere cuando choca al los bordes del la ventana del juego
* cuando choca a los bordes:
	se tiene que reiniciar el juego
	los puntos tiene que estar en 0
	el snake pierde todos los eslabones ganados
* los puntos Perdida incrementa en 1

agregar sonidos
#7
* agrega un sonido de fondo durante la ejecucion
* implementar el sonido cuando el snake come una botana
* un sonido cuando el snake choca a la pared
* un sonido cuando aparesca las botanas
