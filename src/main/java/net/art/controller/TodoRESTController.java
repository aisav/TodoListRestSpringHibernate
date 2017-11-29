package net.art.controller;
 
import net.art.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.art.model.EmployeeListVO;
import net.art.model.Todo;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class TodoRESTController
{
    @Autowired
    TodoService todoService;

//    @RequestMapping(value = "/employees")
    @RequestMapping(value = "/getAllTodos", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getCountries() {

        List listOfCountries = todoService.getAllToDos();
        return listOfCountries;
    }
/*    public @ResponseBody EmployeeListVO getAllEmployees()
    {
        EmployeeListVO employees = new EmployeeListVO();
         
        Todo empOne = new Todo(1,"Lokesh",5,"aannaa@gmail.com");
        Todo empTwo = new Todo(2,"Amit",3,"nanana@yahoo.com");
        Todo empThree = new Todo(3,"Kirti",5,"kmishra@gmail.com");
         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
         
        return employees;
    }*/
    @RequestMapping(value = "/employees/{id}")
    @Transactional
    @ResponseBody
    public ResponseEntity<Todo> getEmployeeById (@PathVariable("id") int id)
    {
        if (id <= 3) {
            Todo employee = new Todo(1,"Lokesh",2,"ananun@gmail.com");
            return new ResponseEntity<Todo>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}