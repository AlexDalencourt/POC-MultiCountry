package com.example.business.contract;

import java.util.UUID;

public record Contract(UUID id, String name, ContractExt ext) {

}
