    document.getElementById('searchForm').addEventListener('submit', function(event){
        event.preventDefault();

        const subject = document.getElementById('subject').value;
        const shift = document.getElementById('shift').value;
        const modality = document.getElementById('modality').value;

        console.log('Pesquisando por:', subject, shift, modality);
        // Aqui você pode adicionar a lógica para buscar as turmas com base nos critérios
    });

    document.addEventListener('DOMContentLoaded', function() {
        fetch('https://seu-endpoint.com/assuntos')
            .then(response => response.json())
            .then(data => {
                const subjectSelect = document.getElementById('subject');
                data.forEach(subject => {
                    let option = document.createElement('option');
                    option.value = subject.id; // supondo que cada assunto tem um ID
                    option.textContent = subject.nome; // e um nome
                    subjectSelect.appendChild(option);
                });
            })
            .catch(error => {
                console.error('Erro ao carregar os assuntos:', error);
            });
    });
    
    // Restante do seu JavaScript...
    
