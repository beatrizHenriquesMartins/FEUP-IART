;(defrule fecha-janela (chove) => (printout t  "Fechando a janela!" crlf))

;(defrule tempo-chuva (chove) => (assert (chuva)))
;(defrule fecha-janela (chuva) => (assert (janela fechada)) (assert (lembrar guarda-chuva)))

;(defrule fecha-janela (chove) => (assert (janela-fechada)))

;(defrule tempo-sol (sol) => (assert (tempo sol)))
;(defrule abre-janela (tempo sol) => (assert (janela aberta)))

;(defrule fecha-janela (chove) => (printout t "Abrindo a janela!" crlf))


(deffacts tempo

    (tempo sol)
    (janela aberta)

)

(reset)

(defrule comeca-chover

    ?old <- (tempo sol)
    ?janela <- (janela aberta)
    ?trigger <- (chuva)
    
    =>

    (printout t "Começa a chover" crlf)
    (retract ?old)
    (retract ?trigger)
    (retract ?janela)
    (assert (tempo chuva))
    (assert (janela fechada))
    
)

(defrule comeca-sol

    ?old <- (tempo chuva)
    ?janela <- (janela fechada)
    ?trigger <- (sol)
    
    =>

    (printout t "Começa a dar sol" crlf)
    (retract ?old)
    (retract ?trigger)
    (retract ?janela)
    (assert (tempo sol))
    (assert (janela aberta))
    
)


/*

objetos:

    - sensor temperatura interior
    - sensor temperatura exterior
    - sensor humidade exterior 
    - sensor ph
    - sensor humidade solo
    - sensor ruído
    - sensor movimento
    - relógio
    - dispositivo de reconhecimento facial
    - sensor químico
    - sensor pressão
    - sensor peso

    - janela
    - luzes
    - aquecedores
    - radiador
    - caldeira
    - ar condicionado
    - porta
    - alarme
    - carro
    - precianas
    - despertador


regras

    - se chover fechar janela
    - se dia abrir preciana
    - se noite fechar janela preciana
    - se cama > peso cama e hora > despertar -> tocar despertador
    - se sensor movimento divisão -> acender luz 



*/

