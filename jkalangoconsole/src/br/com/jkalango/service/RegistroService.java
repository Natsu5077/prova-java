package br.com.jkalango.service; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.JOptionPane;

public class RegistroService {

    public String cadastrarJogador(String nome, String nickName, String email, String senha, String telefone) {
        try {
            URL url = new URL("http://localhost:8080/jogador");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            java.util.Map<String, String> jogadorData = new java.util.HashMap<>();
            jogadorData.put("nome", nome);
            jogadorData.put("nickName", nickName);
            jogadorData.put("email", email);
            jogadorData.put("senha", senha);
            jogadorData.put("telefone", telefone);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInputString = objectMapper.writeValueAsString(jogadorData);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
                System.out.println("API respondeu com sucesso! (Código: " + responseCode + ")");
                return null;
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                try (BufferedReader br = new BufferedReader(
                     new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    String errorJson = response.toString();
                    System.err.println("Erro de validação da API (400): " + errorJson);

                    if (!errorJson.isEmpty()) {
                        java.util.Map<String, String> errors = objectMapper.readValue(errorJson, java.util.Map.class);
                        StringBuilder detailedErrorMessage = new StringBuilder("Erro de validação:\n");
                        for (java.util.Map.Entry<String, String> entry : errors.entrySet()) {
                            detailedErrorMessage.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                        }
                        return detailedErrorMessage.toString();
                    } else {
                        return "Erro de validação" + responseCode;
                    }
                }
            } else {
                String errorMessage = "Erro inesperado da API. Código: " + responseCode;
                try (BufferedReader br = new BufferedReader(
                     new InputStreamReader(connection.getErrorStream() != null ? connection.getErrorStream() : connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    if (response.length() > 0) {
                        errorMessage += "\nMensagem detalhada: " + response.toString();
                    }
                }
                System.err.println(errorMessage);
                return errorMessage;
            }

        } catch (Exception e) {
            String errorMsg = "Ocorreu um erro na comunicação com a API: " + e.getMessage();
            System.err.println(errorMsg);
            e.printStackTrace();
            return errorMsg;
        }
    }
}