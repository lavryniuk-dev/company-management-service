package ua.ukrposhta.internalcompanymanagementapp.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
