package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.person.Release_Date;


//Prisoner class is child class of Person: but each instance has a release date

public class Prisoner extends Person{

    private final Release_Date release_date;

    public Prisoner(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Release_Date release_date) {
        super(name, phone, email, address, tags);
        requireAllNonNull(name, phone, email, address, tags, release_date);
        this.release_date = release_date;
    }

    public Release_Date getRelease_date() {
        return release_date;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Prisoner)) {
            return false;
        }

        Prisoner otherPerson = (Prisoner) other;
        return otherPerson.getName().equals(this.getName())
                && otherPerson.getPhone().equals(this.getPhone())
                && otherPerson.getEmail().equals(this.getEmail())
                && otherPerson.getAddress().equals(this.getAddress())
                && otherPerson.getRelease_date().equals(this.getRelease_date());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(this.getName(), this.getPhone(), this.getEmail(), this.getAddress(), this.getTags(), this.getRelease_date());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        builder.append(" Release Date: ").append(getRelease_date());
        return builder.toString();}
}
