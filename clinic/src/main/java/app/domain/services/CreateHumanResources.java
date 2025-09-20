package app.domain.services;

import app.domain.model.Employee;
import app.domain.ports.EmployeePort;

public class CreateHumanResources {

    private EmployeePort employeePort;

    // MÉTODO 1: Crear Empleado
    public void crearEmpleado(Employee employee) throws Exception {
    

        if (employeePort.findByDocument(employee) != null) {
            throw new Exception("Ya existe un empleado registrado con ese documento");
        }


        employeePort.save(employee);
    }

    // MÉTODO 2: Actualizar Empleado
    public void actualizarEmpleado(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado no puede ser nulo");
        }

        Employee existing = (Employee) employeePort.findByDocument(employee);
        if (existing == null) {
            throw new Exception("No existe un empleado con ese documento");
        }

        existing.setName(employee.getName());
        existing.setRole(employee.getRole());
        existing.setEmail(employee.getEmail());
        existing.setPhone(employee.getPhone());

        employeePort.update(existing);
    }
}
