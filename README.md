# Wordle-Java  
Es una humilde imitación del clásico juego **Wordle**, en una versión para terminal.  

## 📜 Explicación del juego  
El juego consiste en que, dada una palabra, el jugador deberá ingresar otra palabra del mismo número de caracteres. Luego, el sistema mostrará los aciertos de la siguiente manera:  

Ejemplo:  
Si la palabra a adivinar es **COSA** y el jugador introduce **POCA**, el resultado será: `_O*A`.  

### 🔍 Reglas:  
- **Letra correcta en la posición correcta** → Se muestra tal cual.  
- **Letra correcta en la posición incorrecta** → Se muestra como `*`.  
- **Letra incorrecta** → Se muestra como `_`.  

El juego se nutre de las palabras contenidas en un archivo **.txt**. En este repositorio, se incluye uno de ejemplo.  

---
## 🛠️ Requisitos  
Para ejecutar el juego, necesitas tener **Java instalado**. 

## ▶️ Como ejecutarlo
Nos dirigimos a la carpeta donde se encuentra este repositorio y abriremos una terminal, ejecutando la siguiente orden:

```sh
java Wordle (nombre_fichero.txt)
```
📌 Escribir el nombre del fichero es opcional, aunque si no lo hacemos el programa buscará un archivo llamado *diccionario.txt*.

⚠️ Para esto, es importante contar con el archivo *Wordle.class* pues si no, sería necesario compilar previamente.


