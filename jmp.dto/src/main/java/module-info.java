module jmp.dto {
    opens jmp.dto to jmp.cloud.bank.impl, jmp.service.api, jmp.bank.api;
    exports jmp.dto;
}