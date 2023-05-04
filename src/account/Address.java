package account;

public class Address {
        private String street;
        private String city;
        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        // Setters
        public void setStreet(String street) {
            this.street = street;
        }

        public void setCity(String city) {
            this.city = city;
        }

       // Getters
       public String getStreet() {
        return street;
       }

       public String getCity() {
       return city;
       }


}
