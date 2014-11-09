Cliente.
Para compilarlo desde linea de comandos: mvn assembly:assembly 
Para ejecutarlo:
Descargar archivo pdf: java -jar Cliente.jar --download name.pdf
Enviar archivo: java -jar Cliente.jar --upload file.pdf

Opcionamente se usa el parametro -r para renombrar el archivo. Ejemplo: java -jar Cliente.jar --download name.pdf -r name2.pdf
