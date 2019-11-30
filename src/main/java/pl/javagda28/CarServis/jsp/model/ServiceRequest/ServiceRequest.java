package pl.javagda28.CarServis.jsp.model.ServiceRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pl.javagda28.CarServis.jsp.model.IBaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest implements IBaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Double id;

    @CreationTimestamp
    LocalDateTime createDate;// (localdatetime)

    LocalDateTime doneDate; //(ustawiamy na null, a jeśli data realizacji jest ustawiona, to jednoznacznie sugeruje że zlecenie jest wykonane) (localdatetime)
    String content;
    boolean urgent;


    public static class ServiceRequestBuilder
    {
        private Double id;
        private LocalDateTime createDate;
        private LocalDateTime doneDate;
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

        public ServiceRequestBuilder setDoneDate(LocalDateTime doneDate)
        {
            this.doneDate = doneDate;
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
            this.doneDate = null;

            // return new ServiceRequest(content,urgent);
            return new ServiceRequest(id, createDate, doneDate, content, urgent);
        }
    }

}
