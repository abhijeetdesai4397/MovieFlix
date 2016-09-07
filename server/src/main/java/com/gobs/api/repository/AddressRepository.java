package com.gobs.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gobs.api.bean.Address;

@Repository
public class AddressRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Address getAddress(String addressid)
	{
		return entityManager.find(Address.class, addressid);
	}
	
	public Address checkAddress(Address address)
	{
		TypedQuery<Address> query=entityManager.createNamedQuery("Address.checkAddressExist", Address.class);
		query.setParameter("address1", address.getAddress1() );
		query.setParameter("address2", address.getAddress2());
		query.setParameter("city", address.getCity());
		query.setParameter("state", address.getState());
		query.setParameter("country", address.getCountry());
		
		List<Address> addressList=query.getResultList();
		if(addressList.size()>0)
		{
			return addressList.get(0);
		}
		return null;
	}

}
