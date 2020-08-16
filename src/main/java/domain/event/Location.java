package domain.event;

public class Location {
    private String firstLine;           // Required.
    private String secondLine;          // Optional.
    private String city;                // Required.
    private String stateProvince;       // Required.
    private String postCode;            // Required.
    private String country;             // Required.

    public static class Builder {
        private final String firstLine;
        private String secondLine;
        private final String city;
        private final String stateProvince;
        private final String postCode;
        private final String country;

        public Builder(String firstLine, String city, String stateProvince,
                       String postCode, String country) {
            this.firstLine = firstLine;
            this.city = city;
            this.stateProvince = stateProvince;
            this.postCode = postCode;
            this.country = country;
        }

        public Builder setSecondLine(String secondLine) {
            this.secondLine = secondLine;
            return this;
        }

        public Builder build() {
            return this;
        }
    }
}
