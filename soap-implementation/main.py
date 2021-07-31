# This is a sample Python script.
from zeep import Client
import json

from requests import *
# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    url = "http://localhost:7000/ws/EstudianteWebServices?wsdl"
    client = Client(url)
    listAll = client.service.getListaEstudiante()
    print("Lista de estudiantes:")
    print(listAll)
    student = client.service.getEstudiante(20011136)
    print("Estudiante buscado:")
    print(student)

    typeStudent = client.get_type('ns0:estudiante')
    newStudent = typeStudent(matricula=20170465, nombre="Alicia Cruz", carrera="ISC")
    created = client.service.crearEstudiante(newStudent)
    newStudent = typeStudent(matricula=20182033, nombre="Lola Vazquez", carrera="ITT")
    created2 = client.service.crearEstudiante(newStudent)
    print("Lista de estudiantes:")
    print(client.service.getListaEstudiante())
    response = client.service.eliminarEstudiante(20170465)
    print("Estudiante eliminado: ")
    print(response)
    listAll = client.service.getListaEstudiante()
    print("Estudiantes luego de eliminar uno")
    print("Listado de estudiantes:")
    print(listAll)



