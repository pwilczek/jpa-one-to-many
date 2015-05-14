package name.wilu.datasource;

import name.wilu.entity.*;
import name.wilu.entity.Exception;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfiguration.class, JpaConfiguration.class})
public class EntityManagerTest {

    @PersistenceContext
    EntityManager em;

    @Ignore
    @Test
    @Transactional
    @Rollback(false)
    public void shouldAdd() {
        Exception first = new Exception("system", "code", true);
        ExceptionGroup group = new ExceptionGroup("other-system", "other-code");
        group.add(first);
        em.persist(first);
        em.persist(group);
        assertNotNull(em);
    }

    @Ignore
    @Test
    @Transactional
    public void shouldFindByGroup() {
        ExceptionGroup group = em.find(ExceptionGroup.class, 12L);
        assertTrue(group.exceptions().size() == 1);
    }

    @Test
    @Transactional
    public void shouldFindByException(){
        Exception exception = em.find(Exception.class, 9L);
        assertNotNull(exception.group());
    }

}
