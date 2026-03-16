function Detalhes(id) {
            var detalhes = document.getElementById('detalhes-' + id);
            if (detalhes.style.display === 'table-row') {
                detalhes.style.display = 'none';
            } else {
                detalhes.style.display = 'table-row';
            }
        }