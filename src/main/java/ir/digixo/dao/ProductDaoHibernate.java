package ir.digixo.dao;

import ir.digixo.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDaoHibernate implements ProductDao {

    private final SessionFactory sessionFactory;

    public ProductDaoHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from product order by  price desc ")
                .getResultList();
    }

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public Product findById(Long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void delete(Long id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from product where id=:productId")
                .setParameter("productId", id)
                .executeUpdate();
    }
}