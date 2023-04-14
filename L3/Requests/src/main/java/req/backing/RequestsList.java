/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package req.backing;

import data.RequestRepository;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Size;
import java.util.List;
import req.entities.Request;
import java.time.LocalDate;


/**
 *
 * @author Patryk
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {
    
    @Inject 
    private RequestRepository requestRepository;
    @Size(min = 3, max = 60, message = "{request.size}")
    private String newRequest;
    private HtmlDataTable requestsDataTable;
    
    /**
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
    }
    
    public List<Request> getAllRequests() { 
        return requestRepository.findAll();
    }
    
    public String getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }
    
    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }
    
    @Transactional
    public String addRequest() 
    { 
        Request req = new Request();
        req.setRequestDate(LocalDate.now());
        req.setRequestText(newRequest);
        requestRepository.create(req);
        setNewRequest("");
        return null; 
    }
    
    @Transactional  
    public String deleteRequest() { 
        Request req = 
          (Request) getRequestsDataTable().getRowData(); 
        requestRepository.remove(req);
        return null; 
    } 
}
