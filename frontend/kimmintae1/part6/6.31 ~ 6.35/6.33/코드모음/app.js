function main(){
    const BUBBLING_PHASE = false;
    const CAPTURING_PHASE = true;
    const PHASE_NAME = ['NONE', 'CAPTURING', 'TARGET', 'BUBBLING']

    function eventLogger({target, currentTarget}){
        console.log(`${target.dataset.name}, ${currentTarget.dataset.name}, ${PHASE_NAME[e.eventPhase]}`);
    }

    let divs = document.querySelectAll('div');
    divs.forEach(div => div.addEventListener('click', eventLogger, BUBBLING_PHASE));
}

document.addEventListener('DOMContentLoaded', main);