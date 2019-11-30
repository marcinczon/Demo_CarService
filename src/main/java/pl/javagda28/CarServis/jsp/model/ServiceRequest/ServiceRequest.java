package pl.javagda28.CarServis.jsp.model.ServiceRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest
{

    Double id;
    LocalDateTime createDate;// (localdatetime)
    LocalDateTime completionDate; //(ustawiamy na null, a jeśli data realizacji jest ustawiona, to jednoznacznie sugeruje że zlecenie jest wykonane) (localdatetime)
    String content;
    boolean urgent;


    public static class ServiceRequestBuilder
    {
        private Double id;
        private LocalDateTime createDate;
        private LocalDateTime realizedDate;
        private String content;
        private boolean urgent;
        private static double objectCounter = 0;

        private ServiceRequestBuilder setId(Double id)
        {
            this.id = id;
            return this;
        }

        public ServiceRequestBuilder setCreateDate(LocalDateTime createDate)
        {
            this.createDate = createDate;
            return this;
        }

        public ServiceRequestBuilder setRealizedDate(LocalDateTime realizedDate)
        {
            this.realizedDate = realizedDate;
            return this;
        }

        public ServiceRequestBuilder setContent(String content)
        {
            this.content = content;
            return this;
        }

        public ServiceRequestBuilder setUrgent(boolean urgent)
        {
            this.urgent = urgent;
            return this;
        }

        public ServiceRequest createServiceOrder()
        {
            objectCounter++;
            this.id = objectCounter;
            this.createDate = LocalDateTime.now();
            this.realizedDate = null;

            // return new ServiceRequest(content,urgent);
            return new ServiceRequest(id, createDate, realizedDate, content, urgent);
        }
    }

}
