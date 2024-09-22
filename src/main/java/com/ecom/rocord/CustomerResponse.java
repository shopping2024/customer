package com.ecom.rocord;

import com.ecom.model.Address;

public record CustomerResponse(String id,
                                String firstName,
                              String lastName,
                               String email,
                               Address address)
{
}
