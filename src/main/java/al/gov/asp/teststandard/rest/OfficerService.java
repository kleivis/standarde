package al.gov.asp.teststandard.rest;

import al.gov.asp.teststandard.models.OfficerModel;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Programimi-22
 */
public class OfficerService {

    public List<OfficerModel> getOficerss(String name, String surname) {

        String link = "http://deepsee.asp.gov.al/rest/ncr/searchRims?rimsNo=&";

        boolean first = true;
        if (name != null && !"".equals(name)) {
            link += "name=" + name.replaceAll("\\s+", "");
            first = false;
        }
        if (surname != null && !"".equals(surname)) {
            if (!first) {
                link += "&";
            }
            link += "surname=" + surname.replaceAll("\\s+", "");
            first = false;
        }

        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);
        WebResource resource = client.resource(link);
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() == 404) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Info", "Punonjësi nuk u gjet!."));
            return null;
        } else {

            GenericType<List<OfficerModel>> generic = new GenericType<List<OfficerModel>>() {
            };
            List<OfficerModel> output = response.getEntity(generic);

            return output;
        }
    }

}
