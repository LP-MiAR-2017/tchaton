package fr.iut.domain.factory;

public interface IFactory<T> {
  T mkObjectHistory(Object fromRepo);
}
