package br.com.diegopimenta.clientapi.utils;

public final class FormatCpf {

    private FormatCpf() {}

    public static String removeCpfFormat(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    public static String addCpfFormat(String cpf) {
        return cpf.replaceAll(
                "(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
                "$1.$2.$3-$4"
        );
    }
}
