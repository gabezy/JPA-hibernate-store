package br.com.storeJPA.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private PersonalInformation personalInformation;
    @Column(unique = true)
    private String cpf;

    public Client(){}

    public Client(String name, int age, String cpf) {
        this.personalInformation = new PersonalInformation(name, age);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", personalInformation=" + personalInformation +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return personalInformation.getName();
    }

    public void setName(String name) {
        this.personalInformation.setName(name);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
