package es.vedruna.appVedruna.services;

import es.vedruna.appVedruna.model.Incidencia;
import es.vedruna.appVedruna.repository.IncidenciasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncidenciaServiceImpl implements IncidenciaService{
 
    private final IncidenciasRepository incidenciasRepository;

    private final EmailService emailService;
    @Override
    public Incidencia crearIncidencia(Incidencia incidencia) {
        Incidencia nuevaIncidencia = incidenciasRepository.save(incidencia);

        // Configurar el correo
        String asunto = "Nueva Incidencia Reportada: " + incidencia.getTitulo();
        String mensaje = "Detalles de la incidencia:\n\n" +
                "Número de Equipo: " + incidencia.getNumeroEquipo() + "\n" +
                "Título: " + incidencia.getTitulo() + "\n" +
                "Descripción: " + incidencia.getDescripcion() + "\n" +
                "Fecha: " + incidencia.getFecha();

        // Enviar correo
        emailService.enviarCorreo(asunto, mensaje);

        return nuevaIncidencia;
    }
}
