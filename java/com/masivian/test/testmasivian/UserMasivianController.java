package com.masivian.test.testmasivian;

import com.masivian.test.testmasivian.util.JsfUtil;
import com.masivian.test.testmasivian.util.PaginationHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Named("userMasivianController")
@SessionScoped
public class UserMasivianController implements Serializable {

    private UserMasivian current;
    private DataModel items = null;
    @EJB
    private com.masivian.test.testmasivian.UserMasivianFacade ejbFacade;
    @EJB
    private GeoAddressUserMasivianFacade ejbGeo;
    @EJB
    private AddressUserMasivianFacade ejbAddress;
    @EJB
    private CompanyUserMasivianFacade ejbCompany;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public UserMasivianController() {
    }

    public UserMasivian getSelected() {
        if (current == null) {
            current = new UserMasivian();
            selectedItemIndex = -1;
        }
        return current;
    }

    private UserMasivianFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (UserMasivian) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new UserMasivian();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        current = new UserMasivian();
        selectedItemIndex = -1;
        try {

            URL url = new URL("https://jsonplaceholder.typicode.com/users ");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder sb = new StringBuilder();
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            JSONParser salida = new JSONParser();
            Object obj = salida.parse(sb.toString());
            JSONArray array = (JSONArray) obj;
            JSONObject aux, aux2, aux3;
            AddressUserMasivian address;
            GeoAddressUserMasivian geo;
            CompanyUserMasivian company;
            for (int i = 0; i < array.size(); i++) {
                aux = (JSONObject) array.get(i);
                this.current.setId(new BigDecimal(aux.get("id").toString()));
                this.current.setName(aux.get("name").toString());
                this.current.setUsername(aux.get("username").toString());
                this.current.setEmail(aux.get("email").toString());
                this.current.setPhone(aux.get("phone").toString());
                aux2 = (JSONObject) aux.get("address");
                address = new AddressUserMasivian();
                address.setCity(aux2.get("city").toString());
                address.setStreet(aux2.get("street").toString());
                address.setSuite(aux2.get("suite").toString());
                address.setZipcode(aux2.get("zipcode").toString());
                address.setUserId(current);
                aux3 = (JSONObject) aux2.get("geo");
                geo = new GeoAddressUserMasivian();
                geo.setAddressId(address);
                geo.setLat(aux3.get("lat").toString());
                geo.setLng(aux3.get("lng").toString());
                geo.setUserId(current);
                aux3 = (JSONObject) aux.get("company");
                company = new CompanyUserMasivian();
                company.setBs(aux3.get("bs").toString());
                company.setCatchphrase(aux3.get("catchPhrase").toString());
                company.setName(aux3.get("name").toString());
                company.setUserId(current);
                getFacade().create(current);
                this.ejbAddress.create(address);
                this.ejbGeo.create(geo);
                this.ejbCompany.create(company);

            }
            conn.disconnect();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserMasivianCreated"));
            return prepareCreate();
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return null;
        }
    }

    public String prepareEdit() {
        current = (UserMasivian) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserMasivianUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (UserMasivian) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("UserMasivianDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public UserMasivian getUserMasivian(java.math.BigDecimal id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = UserMasivian.class)
    public static class UserMasivianControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UserMasivianController controller = (UserMasivianController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "userMasivianController");
            return controller.getUserMasivian(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof UserMasivian) {
                UserMasivian o = (UserMasivian) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + UserMasivian.class.getName());
            }
        }

    }

}
