package pl.javagda28.CarServis.jsp.service.ServiceRequest;

import pl.javagda28.CarServis.jsp.model.ServiceRequest.ServiceRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum ServiceRequestService
{
    INSTANCE;
    // dodaj zlecenie serwisowe (formularz dodawania zlecenia serwisowego).
    // Na formularzu data dodania oraz data realizacji nie powinna się wyświetlać.
    // Data dodania powinna się ustawiać automatycznie przy stworzeniu obiektu lub po jego dodaniu do kontenera
    // (kontenerem jest albo baza danych, albo lista). Istotne jest podanie treści zlecenia i flagi „czy pilne”.
    // Id nie powinno być pobierane, powinno być generowane przez kontener.

    private List<ServiceRequest> serviceRequestList = new ArrayList<>();

    public void addServiceRequestToList(ServiceRequest serviceRequest)
    {
        serviceRequestList.add(serviceRequest);
    }

    public void removeServiceRequest(Double serviceRequestId)
    {
        serviceRequestList = serviceRequestList.stream()
                .filter(serviceRequest -> !serviceRequest.getId().equals(serviceRequestId)).collect(Collectors.toList());
    }

    public Optional<ServiceRequest> getServiceRequest(Double serviceRequestId)
    {
        return serviceRequestList.stream().filter(serviceRequest -> serviceRequest.getId().equals(serviceRequestId)).findFirst();
    }

    public List<ServiceRequest> getServiceRequestList()
    {
        return serviceRequestList;
    }

    public void updateServiceRequestInformation(Double serviceRequestId, HttpServletRequest request)
    {
        final Optional<ServiceRequest> carOptional = serviceRequestList.stream().filter(serviceRequest -> serviceRequest.getId().equals(serviceRequestId)).findFirst();

        if (carOptional.isPresent())
        {
            carOptional.get().setContent(request.getParameter("serviceRequestParam_content"));
            carOptional.get().setUrgent(request.getParameter("serviceRequestParam_urgent") != null && request.getParameter("serviceRequestParam_urgent").equals("on"));
        } else
        {
            System.out.println("Nie istnieje serviceRequest id=" + serviceRequestId);
        }
    }


}
