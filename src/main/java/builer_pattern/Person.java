package builer_pattern;

public class Person {
    private String name;
    private String surname;

    public static class Builder{
        private Person person;

        public Builder(){
            person = new Person();
        }

        public Builder withName(String name){
            person.name = name;
            return this;
        }

        public Builder withSurname(String surname){
            person.surname = surname;
            return this;
        }

        public Person buid(){
            return person;
        }
    }

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .withName("Alex")
                .withSurname("Gray")
                .buid();

        System.out.println(person.surname);
    }
}
