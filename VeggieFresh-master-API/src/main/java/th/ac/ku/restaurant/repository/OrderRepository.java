package th.ac.ku.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.ku.restaurant.model.User;
import th.ac.ku.restaurant.model.VegOrder;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<VegOrder, UUID>
{
}
