package org.example.dao;

import org.example.entity.Film;
import org.hibernate.Query;
import org.hibernate.SessionFactory;


public class FilmDAO  extends GenericDAO<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getFirstVacantFilm() {
        Query<Film> query = getCurrentSession().createQuery(
                "select f from Film f " +
                        "where f.filmId not in " +
                        "(select distinct film.filmId from Inventory)", Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
