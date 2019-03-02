package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();
        addData();
        for(Customer customer: customerRepository.findAll()){
            System.out.println(customer);
        }
    }

    private void addData() {
        Address address = new Address();
        address.setStreetName("Mockingbird Lane");
        address.setStreetNumber("1313A");
        address.setState("Texas");
        address.setZipcode(123465);

        Address address2 = new Address();
        address2.setStreetName("Red Robin Lane");
        address2.setStreetNumber("1313A");
        address2.setState("Texas");
        address2.setZipcode(123465);

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        addresses.add(address2);

        Customer customer = new Customer("Terrific", "Tom");
        customer.setAddresses(addresses);
        customerRepository.save(customer);

    }
}
