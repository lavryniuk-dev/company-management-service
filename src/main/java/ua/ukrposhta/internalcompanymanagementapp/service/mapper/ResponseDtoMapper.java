package ua.ukrposhta.internalcompanymanagementapp.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
