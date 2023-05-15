package ro.oks.bankend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.oks.bankend.model.CommandLine;

public interface CommandLineRepository extends JpaRepository<CommandLine, String> {
}
